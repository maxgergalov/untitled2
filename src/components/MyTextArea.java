package components;

import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 * Created by Max on 23.03.14.
 */
public class MyTextArea extends JTextComponent {

    private static final String uiClassID = "MyTextArea";


    public MyTextArea() {
        this(null, null, 0, 0);
    }

    public MyTextArea(Document doc, String text, int rows, int columns) {
        super();
        this.rows = rows;
        this.columns = columns;
        if (doc == null) {
            doc = createDefaultModel();
        }
        setDocument(doc);
        if (text != null) {
            setText(text);
            select(0, 0);
        }
        if (rows < 0) {
            throw new IllegalArgumentException("rows: " + rows);
        }
        if (columns < 0) {
            throw new IllegalArgumentException("columns: " + columns);
        }
    }

    public String getUIClassID() {
        return uiClassID;
    }

    protected Document createDefaultModel() {
        return new PlainDocument();
    }

    public void setTabSize(int size) {
        Document doc = getDocument();
        if (doc != null) {
            int old = getTabSize();
            doc.putProperty(PlainDocument.tabSizeAttribute, Integer.valueOf(size));
            firePropertyChange("tabSize", old, size);
        }
    }

    public int getTabSize() {
        int size = 8;
        Document doc = getDocument();
        if (doc != null) {
            Integer i = (Integer) doc.getProperty(PlainDocument.tabSizeAttribute);
            if (i != null) {
                size = i.intValue();
            }
        }
        return size;
    }

    public int getLineCount() {
        Element map = getDocument().getDefaultRootElement();
        return map.getElementCount();
    }

    public int getLineStartOffset(int line) throws BadLocationException {
        int lineCount = getLineCount();
        if (line < 0) {
            throw new BadLocationException("Negative line", -1);
        } else if (line >= lineCount) {
            throw new BadLocationException("No such line", getDocument().getLength() + 1);
        } else {
            Element map = getDocument().getDefaultRootElement();
            Element lineElem = map.getElement(line);
            return lineElem.getStartOffset();
        }
    }

    public int getLineEndOffset(int line) throws BadLocationException {
        int lineCount = getLineCount();
        if (line < 0) {
            throw new BadLocationException("Negative line", -1);
        } else if (line >= lineCount) {
            throw new BadLocationException("No such line", getDocument().getLength() + 1);
        } else {
            Element map = getDocument().getDefaultRootElement();
            Element lineElem = map.getElement(line);
            int endOffset = lineElem.getEndOffset();
            return ((line == lineCount - 1) ? (endOffset - 1) : endOffset);
        }
    }

    public void insert(String str, int pos) {
        Document doc = getDocument();
        if (doc != null) {
            try {
                doc.insertString(pos, str, null);
            } catch (BadLocationException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        int oldVal = this.rows;
        if (rows < 0) {
            throw new IllegalArgumentException("rows less than zero.");
        }
        if (rows != oldVal) {
            this.rows = rows;
            invalidate();
        }
    }

    public int getColumns() {
        return columns;
    }




    public void setFont(Font f) {
        super.setFont(f);
        rowHeight = 0;
        columnWidth = 0;
    }

    protected String paramString() {
        String wrapString = (wrap ?
                "true" : "false");
        String wordString = (word ?
                "true" : "false");

        return super.paramString() +
                ",colums=" + columns +
                ",columWidth=" + columnWidth +
                ",rows=" + rows +
                ",rowHeight=" + rowHeight +
                ",word=" + wordString +
                ",wrap=" + wrapString;
    }


    protected class AccessibleMyTextArea extends AccessibleJTextComponent {


        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet states = super.getAccessibleStateSet();
            states.add(AccessibleState.MULTI_LINE);
            return states;
        }
    }



    private int rows;
    private int columns;
    private int columnWidth;
    private int rowHeight;
    private boolean wrap;
    private boolean word;

}



