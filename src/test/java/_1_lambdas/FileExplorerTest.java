package _1_lambdas;

import org.junit.Test;

import java.util.Arrays;

import static _1_lambdas.FileExplorer.getContent;
import static _1_lambdas.FileExplorer.getDirs;
import static _1_lambdas.FileExplorer.getFiles;
import static _1_lambdas.FileExplorer.sortFiles;

/**
 * @author aostrikov
 */
public class FileExplorerTest {
    @Test
    public void shouldListDirs() {
        printArray(getDirs("/Users/aostrikov"));
    }

    @Test
    public void shouldGetDbFiles() {
        printArray(getFiles("/Users/aostrikov", "^.*\\.db$"));
    }

    @Test
    public void shouldGetAllContent() {
        printArray(getContent("/Users/aostrikov"));
    }

    @Test
    public void shouldSortFiles() {
        printArray(sortFiles(getContent("/Users/aostrikov")));
    }

    private void printArray(Object[] array) {
        System.out.println(Arrays.toString(array));
    }
}
