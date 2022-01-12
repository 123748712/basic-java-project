package oJackGyuo.vo;

import java.time.LocalDateTime;
import java.util.Objects;

public class NoteBoxVO {
	private String sendId; // 보낸 사람
	private String reciveId; // 받는 사람
	private String nBTitle; // 제목
	private String nBBody; // 내용
	private LocalDateTime sendDate; // 보낸 일자

	public NoteBoxVO() {
	}

	public NoteBoxVO(String sendId, String reciveId, String nBTitle, String nBBody, LocalDateTime sendDate) {
		this.sendId = sendId;
		this.reciveId = reciveId;
		this.nBTitle = nBTitle;
		this.nBBody = nBBody;
		this.sendDate = sendDate;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getReciveId() {
		return reciveId;
	}

	public void setReciveId(String reciveId) {
		this.reciveId = reciveId;
	}

	public String getnBTitle() {
		return nBTitle;
	}

	public void setnBTitle(String nBTitle) {
		this.nBTitle = nBTitle;
	}

	public String getnBBody() {
		return nBBody;
	}

	public void setnBBoby(String nBBody) {
		this.nBBody = nBBody;
	}

	public LocalDateTime getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDateTime sendDate) {
		this.sendDate = sendDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nBBody, nBTitle, reciveId, sendDate, sendId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteBoxVO other = (NoteBoxVO) obj;
		return Objects.equals(nBBody, other.nBBody) && Objects.equals(nBTitle, other.nBTitle)
				&& Objects.equals(reciveId, other.reciveId) && Objects.equals(sendDate, other.sendDate)
				&& Objects.equals(sendId, other.sendId);
	}

	@Override
	public String toString() {
		return "NoteBoxVO [sendId=" + sendId + ", reciveId=" + reciveId + ", nBTitle=" + nBTitle + ", nBBody=" + nBBody
				+ ", sendDate=" + sendDate + "]";
	}
}
