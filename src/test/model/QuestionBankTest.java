package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionBankTest {
    private QuestionBank testBank;
    private QuestionBank testBankNamed;
    private Question testQuestion;
    private Question testQuestion2;


    @BeforeEach
    void runBefore() {
        testBank = new QuestionBank("test");
        testBankNamed = new QuestionBank("name");
        testQuestion = new Question("Question 1?", "Yes");
        testQuestion2 = new Question("Question 2?", "Yes");
    }

    @Test
    void testConstructor() {
        assertEquals("test", testBank.getBankName());
        assertEquals(testBank.numQuestions(), 0);

    }

    @Test
    void testConstructorWithName() {
        assertEquals(testBankNamed.getBankName(), "name");
        assertEquals(testBankNamed.numQuestions(), 0);

    }

    @Test
    void testSetters() {
        testBank.setBankName("new name");
        testBankNamed.setBankName("new name 2");

    }

    @Test
    void testAddQuestion() {
        testBank.addQuestion(testQuestion);
        assertEquals(testBank.getRecentQuestion(), testQuestion);
        assertEquals(testBank.numQuestions(), 1);

        testBank.addQuestion(testQuestion2);
        assertEquals(testBank.getRecentQuestion(), testQuestion2);
        assertEquals(testBank.numQuestions(), 2);


    }

    @Test
    void testRemoveQuestion() {
        testBank.addQuestion(testQuestion);
        testBank.addQuestion(testQuestion2);
        testBank.removeQuestion();
        assertEquals(testQuestion, testBank.getRecentQuestion());
        assertEquals(1, testBank.numQuestions());

        testBank.removeQuestion();
        testBank.removeQuestion();
        assertEquals(testBank.numQuestions(), 0);


    }

    @Test
    void testIsEmpty() {
        assertTrue(testBank.isEmpty());
    }

    @Test
    void testGetQuestions() {
        ArrayList<Question> actualQuestions = new ArrayList<Question>();
        assertEquals(actualQuestions, testBank.getQuestions());


        testBank.addQuestion(testQuestion);
        testBank.addQuestion(testQuestion2);
        actualQuestions.add(testQuestion);
        actualQuestions.add(testQuestion2);
        assertEquals(actualQuestions, testBank.getQuestions());
    }

    @Test
    void testGetRecentQuestion() {
        assertEquals(null, testBank.getRecentQuestion());
        testBank.addQuestion(testQuestion);
        assertEquals(testQuestion, testBank.getRecentQuestion());


    }


}
