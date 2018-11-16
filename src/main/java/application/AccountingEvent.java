package application;

public class AccountingEvent {

    private final long eventId;
    private final String content;

    public AccountingEvent(long eventId, String content) {
        this.eventId = eventId;
        this.content = content;
    }

    public long getEventId() {
        return eventId;
    }

    public String getContent() {
        return content;
    }
}