package cn.gb2260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class GB2260 {

    private final Revision revision;

    private HashMap<String, String> data;

    private ArrayList<Division> provinces;

    public GB2260() {
        this(Revision.V2014);
    }

    public GB2260(Revision revision) {
        this.revision = revision;
        data = new HashMap<String, String>();
        provinces = new ArrayList<Division>();
        InputStream inputStream = getClass().getResourceAsStream("/data/" + revision.getCode() + ".txt");
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while (r.ready()) {
                String line = r.readLine();
                String[] split = line.split("\t");
                String code = split[0];
                String name = split[1];
                data.put(code, name);
                if (Pattern.matches("^\\d{2}0{4}$", code)) {
                    Division division = new Division();
                    division.setCode(code);
                    division.setName(name);
                    provinces.add(division);
                }
            }
        } catch (IOException e) {
            System.err.println("Error in loading GB2260 data!");
            throw new RuntimeException(e);
        }
    }

    public Division getDivision(String code) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Revision getRevision() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<Division> getProvinces() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<Division> getPrefectures(String code) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<Division> getCounties(String code) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
