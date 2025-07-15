import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Topic {
    private final ConcurrentLinkedQueue<String> mensajes = new ConcurrentLinkedQueue<>();
    private final AtomicBoolean activo = new AtomicBoolean(true);

    public void publish(String message) {
        mensajes.add(message);
    }

    public String consume() {
        return mensajes.poll();
    }

    public void shutdown() {
        activo.set(false);
    }

    public boolean getActivo() {
        return activo.get();
    }
}