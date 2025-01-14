plugins {
	java
	id("io.freefair.lombok") version "8.4"
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

plugins.apply("io.spring.dependency-management")

group = "com.training"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenLocal()
	maven {
		url = uri("https://repo.maven.apache.org/maven2/")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	compileOnly("org.projectlombok:lombok")

	runtimeOnly("mysql:mysql-connector-java:8.0.30")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.github.springtestdbunit:spring-test-dbunit:1.3.0")
	testImplementation("org.dbunit:dbunit:2.7.3") {
		exclude(group = "org.postgresql", module = "postgresql")
	}
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
