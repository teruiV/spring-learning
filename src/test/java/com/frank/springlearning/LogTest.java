package com.frank.springlearning;

import com.frank.springlearning.service.LogService;
import com.frank.springlearning.service.RegistryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jianweilin
 * @date 2018/8/21
 */
@SpringBootTest(classes = SpringLearningApplication.class)
//@RunWith(SpringRunner.class)
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class LogTest {
    @Autowired
    @Mock
    private LogService logService;

    @Autowired
    @InjectMocks
    private RegistryService registryService;


//    @Before
//    public void init() {
//        logService = mock(LogService.class);
//        when(logService.createRoute("测试")).thenReturn("mock create route");
//        registryService = new RegistryService(logService);
//    }
//
//    @Test
//    public void test_001() {
//        when(logService.createRoute("测试")).thenReturn("mock create route");
//        registryService.mock("测试");
//    }
}
