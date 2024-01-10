package parts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class StorageTest {



@Test
public void run() {
    Storage storage = new Storage();
        String d = storage.part[0];
        String[] vs = d.split("[*]");

        if (vs[2].equals("interior"))
            assertEquals(vs[0], storage.getCatalog().interior.getProducts().get(0).getName());

    }
}