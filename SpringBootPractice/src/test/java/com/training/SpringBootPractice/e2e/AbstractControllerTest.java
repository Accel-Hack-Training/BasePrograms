package com.training.SpringBootPractice.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.SpringBootPractice.model.User;
import com.training.SpringBootPractice.utils.ObjectMapperUtils;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.filter.OncePerRequestFilter;

public class AbstractControllerTest {
  protected OncePerRequestFilter[] filterList = new OncePerRequestFilter[0];

  protected ObjectMapper objectMapper = ObjectMapperUtils.getMapper();
  protected MockMvc mockMvc;


  @Data
  @Builder
  protected static class BuilderOption {
    @Builder.Default private String Authorization = "";
    @Builder.Default private HttpMethod method = HttpMethod.POST;
    @Builder.Default private MediaType contentType = MediaType.APPLICATION_JSON;
  }

  protected ResultActions performPost(String path, String content) throws Exception {
    return mockMvc.perform(builder(path, content, BuilderOption.builder().method(HttpMethod.POST).build()));
  }

  protected ResultActions performGet(String path) throws Exception {
    return mockMvc.perform(builder(path, "", BuilderOption.builder().method(HttpMethod.GET).build()));
  }

  protected ResultActions performPut(String path, String content) throws Exception {
    return mockMvc.perform(builder(path, content, BuilderOption.builder().method(HttpMethod.PUT).build()));
  }

  protected ResultActions performDelete(String path) throws Exception {
    return mockMvc.perform(builder(path, "", BuilderOption.builder().method(HttpMethod.DELETE).build()));
  }

  protected MockHttpServletRequestBuilder builder(
    String path, String content, BuilderOption option) {

    MockHttpServletRequestBuilder requestBuilder;
    if (option.method.equals(HttpMethod.GET)) {
      requestBuilder = MockMvcRequestBuilders.get(path);
    } else if (option.method.equals(HttpMethod.PUT)) {
      requestBuilder = MockMvcRequestBuilders.put(path);
    } else if (option.method.equals(HttpMethod.DELETE)) {
      requestBuilder = MockMvcRequestBuilders.delete(path);
    } else {
      requestBuilder = MockMvcRequestBuilders.post(path);
    }
    ;

    return requestBuilder
      .contentType(option.contentType)
      .characterEncoding("UTF-8")
      .content(content);
  }
}
