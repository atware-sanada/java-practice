import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class IssueFactoryTest {

    @Test
    void test_create() {
        String result = IssueFactory.create("質問", "回答");
        String expectResult = "### Question\n> 質問" + "\n\n### Answer\n回答";
        assertEquals(expectResult, result);
    }

    @Test
    void test_create_multiline() {
        String result = IssueFactory.create("質問\n2行目", "回答");
        String expectResult = "### Question\n> 質問\n> 2行目" + "\n\n### Answer\n回答";
        assertEquals(expectResult, result);
    }

    @Test
    void test_create_multiline_answer() {
        String result = IssueFactory.create("質問\n2行目", "回答\n2行目");
        String expectResult = "### Question\n> 質問\n> 2行目" + "\n\n### Answer\n回答\n2行目";
        assertEquals(expectResult, result);
    }

    @Test
    void test_formatQuestion() {
        String result = IssueFactory.formatQuestion("質問");
        String expectResult = "### Question\n> 質問";
        assertEquals(expectResult, result);
    }
}