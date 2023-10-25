package com.smhrd.dream.jpa.specification;

import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import com.smhrd.dream.entity.Diary;

public class DiarySpecification {

	public static Specification<Diary> withIdAndDate(Long id, String registrationDate) {
		return (root, query, criteriaBuilder) -> {
			Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
			Predicate datePredicate = criteriaBuilder.equal(root.get("registrationDate"), registrationDate);
			return criteriaBuilder.and(idPredicate, datePredicate);
		};
	}

}
