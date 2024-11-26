import java.util.ArrayList;
import java.util.List;

public class Member {
    private String firstName;
    private String lastName;
    private String libraryId;
    private String password;
    private static List<Member> memberList = new ArrayList<>();

    public Member(String firstName, String lastName, String libraryId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.libraryId = libraryId;
        this.password = password;
    }

    @Override
    public String toString() {
        return firstName + "  " + lastName + "  " + libraryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public String getPassword() {
        return password;
    }

    public static List<Member> getMemberList() {
        return memberList;
    }

    public static void removeMember(Member m) {
        memberList.remove(m);
    }

    public static void removeLibrarian(Member m) {
        Librarian.getLibrarianList().remove(m);
    }
}
