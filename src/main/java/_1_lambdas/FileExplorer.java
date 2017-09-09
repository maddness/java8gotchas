package _1_lambdas;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author aostrikov
 */
public class FileExplorer {
    public static File[] getContent(String path) {
        return new File(path).listFiles();
    }

    public static File[] getDirs(String path) {
        File dir = new File(path);
        checkArgument(dir.isDirectory());
        return dir.listFiles(File::isDirectory);
    }

    public static File[] getFiles(String path, String ext) {
        File dir = new File(path);
        checkArgument(dir.isDirectory());
        return dir.listFiles((folder, name) -> name.matches(ext));
    }

    public static File[] sortFiles(File[] files) {
        Arrays.sort(files, Comparator.comparing(File::isDirectory).thenComparing(File::toString));
        return files;
    }
}
