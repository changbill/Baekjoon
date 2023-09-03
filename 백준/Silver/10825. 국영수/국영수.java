import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;


class Student {
    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;

    public Student(String name, int korScore, int engScore, int mathScore) {
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public String getName() {
        return name;
    }

    public int getKorScore() {
        return korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public int getMathScore() {
        return mathScore;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        String[] Arr = new String[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if(o1.getKorScore() > o2.getKorScore()) {
                            return -1;
                        } else if(o1.getKorScore() < o2.getKorScore()) {
                            return 1;
                        } else {
                            if(o1.getEngScore() > o2.getEngScore()) {
                                return 1;
                            } else if(o1.getEngScore() < o2.getEngScore()) {
                                return -1;
                            } else {
                                if(o1.getMathScore() > o2.getMathScore()) {
                                    return -1;
                                } else if (o1.getMathScore() < o2.getMathScore()) {
                                    return 1;
                                } else {
                                    return o1.getName().compareTo(o2.getName());
                                }
                            }
                        }
                    }
                });

        for (int i = 0; i < N; i++) {
            sb.append(list.get(i).getName()).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}