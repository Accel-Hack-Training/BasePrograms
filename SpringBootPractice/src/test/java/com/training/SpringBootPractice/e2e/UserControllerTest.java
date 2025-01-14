package com.training.SpringBootPractice.e2e;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.training.SpringBootPractice.dataset.CsvDataSetLoader;
import com.training.SpringBootPractice.model.User;
import com.training.SpringBootPractice.utils.ObjectMapperUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestExecutionListeners({
  DependencyInjectionTestExecutionListener.class,
  TransactionDbUnitTestExecutionListener.class
})
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class UserControllerTest extends AbstractControllerTest {
  @Autowired
  private WebApplicationContext webApplicationContext;


  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilters(filterList).build();
  }

  @Test
  @DatabaseSetup(value = "/database/testdata")
  public void getUserList() throws Exception {
    final var url = "/users";

    performGet(url)
      .andExpect(status().isOk())
      .andExpect(jsonPath("$").value(hasSize(9)))
      .andExpect(jsonPath("$[0].name").value("admin"))
      .andExpect(jsonPath("$[1].name").value("owner"))
      .andExpect(jsonPath("$[2].name").value("student1"))
      .andExpect(jsonPath("$[3].name").value("student2"))
      .andExpect(jsonPath("$[4].name").value("student3"))
      .andExpect(jsonPath("$[5].name").value("student4"))
      .andExpect(jsonPath("$[6].name").value("student5"))
      .andExpect(jsonPath("$[7].name").value("student6"))
      .andExpect(jsonPath("$[8].name").value("student7"));
  }

  @Test
  @DatabaseSetup(value = "/database/testdata")
  public void createUser() throws Exception {
    final var url = "/users";

    // before
    performGet(url)
      .andExpect(status().isOk())
      .andExpect(jsonPath("$").value(hasSize(9)));

    User newUser =
      User.builder()
        .name("newUser")
        .email("mewUser@accelhack-training.com")
        .password("password")
        .build();

    performPost(url, ObjectMapperUtils.getMapper().writeValueAsString(newUser))
      .andExpect(status().isOk());

    // after
    performGet(url)
      .andExpect(status().isOk())
      .andExpect(jsonPath("$").value(hasSize(10)))
      .andExpect(jsonPath("$[9].name").value("newUser"));
  }

}
