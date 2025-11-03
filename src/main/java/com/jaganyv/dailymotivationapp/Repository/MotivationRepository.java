package com.jaganyv.dailymotivationapp.Repository;

import com.jaganyv.dailymotivationapp.Model.Motivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivationRepository extends JpaRepository<Motivation,Long> {
}
