insert into Course (title,description, begin_date, end_date, price)
values ('Test course title','Test course description', '2000-01-01', '2000-02-02', 100.0);




mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect((jsonPath("$.[1].id", is(2))))
                .andExpect((jsonPath("$.[1].title", is("Test course title"))))
                .andExpect((jsonPath("$.[1].description", is("Test course description"))))
                .andExpect((jsonPath("$.[1].beginDate", is("2000-01-01"))))
                .andExpect((jsonPath("$.[1].endDate", is("2000-02-02"))))
                .andExpect((jsonPath("$.[1].price", is(100.0))))
                .andExpect((jsonPath("$.[1].state", is("DRAFT"))));