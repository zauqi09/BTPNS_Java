import java.util.*;
import java.io.*;
public class table {
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;
    
    public table() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }

    //save to file
    public void savetofile() {
        try {
            FileWriter writer = new FileWriter("Mahasiswa.txt");
            BufferedWriter buffer = new BufferedWriter(writer);   
            int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

            for (String[] cells : rows) {
                if (maxWidths == null) {
                    maxWidths = new int[cells.length];
                }
                if (cells.length != maxWidths.length) {
                    throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
                }
                for (int i = 0; i < cells.length; i++) {
                    maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
                }
            }

            if (headers != null) {
                //save line
                for (int i = 0; i < maxWidths.length; i++) {
                    String line = String.join("", Collections.nCopies(maxWidths[i] +
                            verticalSep.length() + 1, HORIZONTAL_SEP));
                    buffer.write(joinSep + line + (i == maxWidths.length - 1 ? joinSep : ""));
                }
                buffer.write("\n");

                //save row
                for (int i = 0; i < headers.length; i++) {
                    String s = headers[i];
                    String verStrTemp = i == headers.length - 1 ? verticalSep : "";
                    if (rightAlign) {
                        buffer.write(String.format("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    } else {
                        buffer.write(String.format("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    }
                }
                buffer.write("\n");

                //save line
                for (int i = 0; i < maxWidths.length; i++) {
                    String line = String.join("", Collections.nCopies(maxWidths[i] +
                            verticalSep.length() + 1, HORIZONTAL_SEP));
                            buffer.write(joinSep + line + (i == maxWidths.length - 1 ? joinSep : ""));
                }
                buffer.write("\n");
            }
            for (String[] cells : rows) {
                //save row
                for (int i = 0; i < cells.length; i++) {
                    String s = cells[i];
                    String verStrTemp = i == cells.length - 1 ? verticalSep : "";
                    if (rightAlign) {
                        buffer.write(String.format("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    } else {
                        buffer.write(String.format("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    }
                }
                buffer.write("\n");
            }
            if (headers != null) {
                for (int i = 0; i < maxWidths.length; i++) {
                    String line = String.join("", Collections.nCopies(maxWidths[i] +
                            verticalSep.length() + 1, HORIZONTAL_SEP));
                    buffer.write(joinSep + line + (i == maxWidths.length - 1 ? joinSep : ""));
                }
                buffer.write("\n");
            }
            buffer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}