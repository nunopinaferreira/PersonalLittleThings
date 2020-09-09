import org.w3c.dom.Node;

/*
import java.util.LinkedList;
import java.util.Optional;

public class LinkedListMiddle {


    public static Optional<String> findMiddleElementFromHead1PassIteratively(Node head) {
        if (head == null) {
            return Optional.empty();
        }

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer.hasNext() && fastPointer.next().hasNext()) {
            fastPointer = fastPointer.next().next();
            slowPointer = slowPointer.next();
        }

        return Optional.ofNullable(slowPointer.data());
    }

    // We can test this solution with a simple unit test using lists with both odd and even number of elements:


    public void whenFindingMiddleFromHead1PassIteratively_thenMiddleFound() {

        assertEquals("3", MiddleElementLookup
                .findMiddleElementFromHead1PassIteratively(
                        createNodesList(5)).get());
        assertEquals("2", MiddleElementLookup
                .findMiddleElementFromHead1PassIteratively(
                        reateNodesList(4)).get());
    }
}


 */