import java.time.LocalDateTime;

public class Todo {
    // Wenn der Accessmodifier(public, protected, private) bei den Attributen fehlt
    // ist es per standard: (default) package private
    String text;  // null
    boolean checked; // false
    LocalDateTime created; // null

    Todo(String text) {
        this.text = text;
        this.created = LocalDateTime.now(); // Besorgt sich die aktuelle Systemzeit
    }

    @Override // Die Override-Annotation ist freiwillig und passt auf, dass diese Methode wirklich eine andere überschreibt
    public String toString() {
        return "Todo{" +
                "text='" + text + '\'' +
                ", checked=" + checked +
                ", created=" + created +
                '}';
    }
}
