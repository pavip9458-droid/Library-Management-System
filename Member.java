import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private int memberId;
    private String memberName;
    private String phoneNumber;

    public Member(int memberId, String memberName, String phoneNumber) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
