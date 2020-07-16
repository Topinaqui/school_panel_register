package com.faiton.school_panel_dashboard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchoolPanelDashboardApplicationTests {

	// @Test
	void contextLoads() {
		String str = "String";

		assertThat(str).isNotNull();
	}

}
