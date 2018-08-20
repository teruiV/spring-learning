//package com.frank.springlearning;
//
//import com.frank.springlearning.service.UserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import org.mockito.InOrder;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
///**
// * @author jianweilin
// * @date 2018/7/18
// */
//@RunWith(JUnit4.class)
//public class MockTest {
//
//    @Test
//    public void test_001(){
//        //You can mock concrete classes, not just interfaces
//        LinkedList mockedList = mock(LinkedList.class);
//
//        //stubbing
//        when(mockedList.get(0)).thenReturn("first");
////        when(mockedList.get(1)).thenThrow(new RuntimeException());
//
//        //following prints "first"
//        System.out.println(mockedList.get(0));
//
//        //following throws runtime exception
//        System.out.println(mockedList.get(1));
//
//        //following prints "null" because get(999) was not stubbed
//        System.out.println(mockedList.get(999));
//
//        //Although it is possible to verify a stubbed invocation, usually it's just redundant
//        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
//        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
//        verify(mockedList).get(0);
//    }
//
//    @Test
//    public void test_002(){
//        UserService mockUser = mock(UserService.class);
//        when(mockUser.test_001()).thenReturn(Arrays.asList("This","Is","Mock"));
//        Assert.assertSame(Arrays.asList("This","Is","Mock"),mockUser.test_001());
//        System.out.println(mockUser.test_001());
//
//    }
//
//    @Test
//    public void test_003(){
//        //You can mock concrete classes, not just interfaces
//        LinkedList mockedList = mock(LinkedList.class);
//
//        //using mock
//        mockedList.add("once");
//        mockedList.add("once");
//
//        mockedList.add("twice");
//        mockedList.add("twice");
//
//        mockedList.add("three times");
//        mockedList.add("three times");
//        mockedList.add("three times");
//
//        //following two verifications work exactly the same - times(1) is used by default
//        verify(mockedList).add("once");
//        verify(mockedList, times(2)).add("once");
//
//        //exact number of invocations verification
//        verify(mockedList, times(2)).add("twice");
//        verify(mockedList, times(3)).add("three times");
//
//        //verification using never(). never() is an alias to times(0)
//        verify(mockedList, never()).add("never happened");
//
//        //verification using atLeast()/atMost()
//        verify(mockedList, atLeastOnce()).add("three times");
//        verify(mockedList, atLeast(2)).add("three times");
//        verify(mockedList, atMost(5)).add("three times");
//    }
//
//    @Test
//    public void test_004(){
//        // A. Single mock whose methods must be invoked in a particular order
//        List singleMock = mock(List.class);
//
//        //using a single mock
//        singleMock.add("was added first");
//        singleMock.add("was added second");
//
//        //create an inOrder verifier for a single mock
//        InOrder inOrder = inOrder(singleMock);
//
//        //following will make sure that add is first called with "was added first, then with "was added second"
//        inOrder.verify(singleMock).add("was added first");
//        inOrder.verify(singleMock).add("was added second");
//
//        // B. Multiple mocks that must be used in a particular order
//        List firstMock = mock(List.class);
//        List secondMock = mock(List.class);
//
//        //using mocks
//        firstMock.add("was called first");
//        secondMock.add("was called second");
//
//        //create inOrder object passing any mocks that need to be verified in order
////        InOrder inOrder = inOrder(firstMock, secondMock);
////
////        //following will make sure that firstMock was called before secondMock
////        inOrder.verify(firstMock).add("was called first");
////        inOrder.verify(secondMock).add("was called second");
//
//        // Oh, and A + B can be mixed together at will
//    }
//}
