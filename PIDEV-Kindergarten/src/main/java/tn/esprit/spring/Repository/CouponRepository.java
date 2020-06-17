package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Coupon;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
