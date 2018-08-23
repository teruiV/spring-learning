package com.frank.springlearning;

import com.frank.springlearning.domain.Role;
import com.frank.springlearning.domain.User;
import com.frank.springlearning.service.LogService;
import com.frank.springlearning.service.RegistryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.context.annotation.Description;

import java.util.Arrays;
import java.util.LinkedList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author jianweilin
 * @date 2018/8/23
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MockApiTest {

    @Mock
    private LinkedList mockList;

    @Spy
    private LinkedList real = new LinkedList();

    @InjectMocks
    private User user;

    @Mock
    private Role role;

    @Spy
    private LogService logService;

    @InjectMocks
    private RegistryService registryService;

    @Test
    @Description("mock某个类的方法")
    public void test_001(){
        when(mockList.get(0)).thenReturn("first");

        System.out.println(mockList.get(0));
        System.out.println(mockList.get(1));

        // 校验是否调用了1次，mockList的get(0)方法；
        verify(mockList).get(0);
    }

    @Test
    @Description("mock某个方法的任意参数")
    public void test_002(){
        when(mockList.get(anyInt())).thenReturn("element");

        System.out.println(mockList.get(999));
        verify(mockList).get(anyInt());
    }

    @Test
    @Description("校验mock某个方法被调用n次")
    public void test_003(){
        // 使用mock的方法
        mockList.add("once");

        mockList.add("twice");
        mockList.add("twice");

        mockList.add("three times");
        mockList.add("three times");
        mockList.add("three times");

        verify(mockList).add("once");
        verify(mockList,times(2)).add("twice");
        verify(mockList,times(3)).add("three times");
        verify(mockList,never()).add("never happen");
        verify(mockList,atLeastOnce()).add("three times");
    }

    @Test
    @Description("验证某个方法，整个完成时间在100毫秒内完成且被调用1次")
    public void test_004(){
        mockList.add("one");
        verify(mockList,timeout(100).times(1)).add("one");
    }

    @Test
    @Description("调用某个mock方法时，抛出异常")
    public void test_005(){
        doThrow(new RuntimeException("void method throw exception")).when(mockList).clear();

        mockList.clear();
    }

    @Test
    @Description("调用某方法时，触发回调方法")
    public void test_006(){
        when(mockList.add(anyString())).thenAnswer(new Answer<Object>() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();
                log.info("called with arguments: {}" , Arrays.toString(args));
                return true;
            }
        });
        System.out.println(mockList.add("foo"));
    }

    @Test
    @Description("mock对象，无法调用真实方法")
    public void test_007(){
        mockList.add("real object");
        log.info("get one = {}",mockList.get(0));
    }

    @Test
    @Description("部分方法mock，部分可以调用真实方法")
    public void test_008(){
        real.add("one");
        real.add("two");
        when(real.size()).thenReturn(100);

        log.info("get one = {}",real.get(0));
        log.info("mock list size = {}",real.size());
    }

    @Test
    @Description("没有mock的方法，返回默认值")
    public void test_009(){
        LinkedList mock = mock(LinkedList.class, Mockito.RETURNS_SMART_NULLS);
        when(mock.size()).thenReturn(10);
        log.info("mock size = {}",mock.size());
        log.info("unstub method = {}",mock.get(0));
    }

    @Test
    @Description("重置mock方法")
    public void test_010(){
        when(mockList.size()).thenReturn(10);
        log.info("mock size = {}", mockList.size());
        reset(mockList);
        log.info("reset mock size = {}", mockList.size());
    }

    @Test
    @Description("mock内部依赖")
    public void test_011(){
        when(role.getRoleName()).thenReturn("【mock】admin");
        log.info("user info = {}",user.getUserInfo());
    }

    @Test
    @Description("mock spring service层的内部依赖")
    public void test_012(){
        when(logService.createRoute(anyString())).thenReturn("[mock] create route");
        registryService.mock("测试");
        log.info(">>>>>>>>>>> 可否调用正常的方法 >>>>>>>>>>>>\n");
        registryService.registry();
    }
}