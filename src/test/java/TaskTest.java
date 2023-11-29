import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить родителям");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNotMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать родителям");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Яйца");


        Assertions.assertTrue(actual);
    }

    @Test
    public void testNotMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Сливки");


        Assertions.assertFalse(actual);
    }

    @Test
    public void testMatchesMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertTrue(actual);

    }

    @Test
    public void testMatchesMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testNotMatchesMeetingTopicProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Прога Банка");
        Assertions.assertFalse(actual);
    }
}