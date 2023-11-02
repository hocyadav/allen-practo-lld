package io.hari.lld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@NoRepositoryBean
public interface BaseRepo<T> extends JpaRepository<T, Long> {
}
