package persistence;

import org.json.JSONObject;

// interface of Json classes, have toJson method
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
