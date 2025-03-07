package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    public void changed() {
    }

    public void setUnsavedChanges(boolean b) {
    }

    public boolean getUnsavedChanges() {
        return true;
    }

    public void setFileName(String fName) {
    }

    public String getFileName() {
        return "";
    }
}
