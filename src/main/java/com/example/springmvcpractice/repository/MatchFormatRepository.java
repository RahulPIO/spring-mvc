package com.example.springmvcpractice.repository;

import com.example.springmvcpractice.entity.MatchFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatchFormatRepository extends JpaRepository<MatchFormat, Integer> {

    List<MatchFormat> findByFormat(String format);

    MatchFormat findByFormatAndPlayerId(String format, int id);

    List<MatchFormat> findByAverageGreaterThan(int average);

    List<MatchFormat> findByStrikeRateGreaterThan(int strikeRate);

    MatchFormat findTopByOrderByAverageDesc();

    List<MatchFormat> findTop3ByOrderByAverageDesc();

    boolean existsById(int id);
}
