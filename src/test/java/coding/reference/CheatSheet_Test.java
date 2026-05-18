package test.java.coding.reference;

import main.java.coding.reference.CheatSheet;
import org.junit.jupiter.api.Test;

class CheatSheet_Test {
    CheatSheet cheatSheet = new CheatSheet();

    @Test
    void String_사용법() {
        System.out.println("=== String / StringBuilder ===");
        cheatSheet.stringUsage();
        System.out.println();
    }

    @Test
    void List_사용법() {
        System.out.println("=== ArrayList ===");
        cheatSheet.listUsage();
        System.out.println();
    }

    @Test
    void ArrayDeque_사용법() {
        System.out.println("=== ArrayDeque ===");
        cheatSheet.arrayDequeUsage();
        System.out.println();
    }

    @Test
    void PriorityQueue_사용법() {
        System.out.println("=== PriorityQueue (Min/Max Heap) ===");
        cheatSheet.priorityQueueUsage();
        System.out.println();
    }

    @Test
    void HashSet_사용법() {
        System.out.println("=== HashSet ===");
        cheatSheet.hashSetUsage();
        System.out.println();
    }

    @Test
    void HashMap_사용법() {
        System.out.println("=== HashMap ===");
        cheatSheet.hashMapUsage();
        System.out.println();
    }

}