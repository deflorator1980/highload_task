package filesort;

/**
 * Created by a on 22.11.16.
 */
import java.util.List;
import java.io.IOException;

public interface FileSortStorage<T> extends Iterable<T> {
    public void setObjects(List<T> objects) throws IOException;
}
