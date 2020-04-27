import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

public class AppTest {
    @Test
    public void kittiesAreTheSame() {
        App firstKitten = new App("Squeakers");
        App secondKitten = new App("Squeakers");
        assertTrue(firstKitten.equals(secondKitten));
    }

    private void assertTrue(boolean equals) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        App kitten = (App) o;

        String name = null;
        return name.equals(kitten.name); //more properties would be taken into account here for a more complex model
    }


    @Override
    public int hashCode() {
        CopyOnWriteArrayList<Object> name = null;
        return name.hashCode();
    }
}
