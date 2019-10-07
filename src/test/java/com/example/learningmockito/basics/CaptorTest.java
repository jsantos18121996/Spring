package com.example.learningmockito.basics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CaptorTest {

    @Mock
    List<String> mockedList;

    /* @Captor: ... */
    @Captor
    ArgumentCaptor<String> captor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        verify(mockedList).add(captor.capture());

        assertEquals("one", captor.getValue());
    }
}
