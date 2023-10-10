package hello.hellospring.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId; // 회원키

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	// 캠페인 상태
	enum CampaignStatus {
		TEMPORAL_STORE, // 임시저장
		WAITING, // 대기중
		PROGRESSING, // 진행중
		PAUSED, // 일시정지
		URGENT_TERMINATED, // 긴급종료
		BUGET_DEPLETED, // 금액 소진
		CLOSED, // 마감
		EXPIRED, // 기간만료
	}

	@Column(name = "campaign_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private CampaignStatus campaignStatus; // 캠페인 상태

	// 캠페인 전시설정 상태
	enum PublishStatus {
		WAITING, // 대기
		DISPLAYED, // 노출
		NONDISPLAYED // 미노출
	}

	@Column(name = "publich_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private PublishStatus publishStatus; // 캠페인 전시설정

	// 심사 상태
	enum AssessmentStatus {
		POST_REQUEST, // 게시요청됨
		POST_REVIEW, // 게시 심사중
		EDIT_REQUEST, // 수정 요청
		EDIT_REVIEW, // 수정 심사중
		APPROVED, // 승인됨
		REJECTED // 거부
	}

	@Column(name = "assessment_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private AssessmentStatus assessmentStatus; // 심사상태

	// 마케터 노출 설정 상태
	enum MarketerExposureStatus {
		CLASS, // 신분
		RELIABLITY, // 신뢰도
		GRADE, // 등급
		SPECIAL, // 스페셜 노출
	}

	@Column(name = "marketer_exposure_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private MarketerExposureStatus marketerExposureStatus; // 마케터 노출 설정

	@Column(nullable = false)
	private LocalDateTime start; // 캠페인 시작 시각

	@Column(nullable = false)
	private LocalDateTime end; // 캠페인 종료시각

	@Column(name = "total_budget", nullable = false)
	private Long totalBudget;

	@Column(name = "daily_budget_limit")
	private Long dailyBudgetLimit;

	@Column(name = "daily_count_limit")
	private Integer dailyCountLimit;
	
	
}
