package com.example.repository;

import com.example.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * Memberオブジェクトを生成するローマッパー.
     */
    private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
        // ここに結果の処理を書く
        Member member = new Member();
        member.setId(rs.getInt("id"));
        member.setName(rs.getString("name"));
        member.setAge(rs.getInt("age"));
        member.setDepartmentId(rs.getInt("departmentId"));
        return member;
    };
    /**
     * メンバー一覧情報を年齢順で取得します.
     *
     * @return 全メンバー一覧 メンバーが存在しない場合はサイズ0件のメンバー一覧を返します
     */
    public List<Member> findAll() {
//        String sql = “ここにSQL文を書く“;
        String sql = "select id, name, age, departmentId from members order by id";
//        List<Member> memberList = null; // ←ここに実行の処理を書く
        List<Member> memberList = template.query(sql, MEMBER_ROW_MAPPER);
        return memberList;
    }
    /**
     * 主キー検索を行います.
     *
     * @param id 検索したい主キーの値
     * @return メンバー情報(検索されなかった場合は非検査例外が発生します)
     */
    public Member findById(Integer id) {
//        String sql = “ここにSQL文を書く“;
        String sql = "select id, name, age, departmentId from members where id = :id ";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
//        Member member = null; // ←ここに実行処理を書く
        Member member = template.queryForObject(sql, param, MEMBER_ROW_MAPPER);
        return member;
    }
    /**
     * メンバー情報を登録or更新します.
     *
     * @param member メンバー情報
     * @return メンバー情報
     */
    public Member save(Member member) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(member);
        if (member == null) { // ←正しい条件に修正する
//            String insertSql = “ここにSQL文を書く“;
            String insertSql = "insert into members(id, name, age, departmentId)" +
                    "values(:name, :age, :departmentId)";
            // ここに実行処理を書く
            template.update(insertSql,param);
        } else {
//            String updateSql = “ここにSQL文を書く“;
            String updateSql = "update members set name = :name, age = :age, departmentId = :departmentId" +
                    "where id = :id";
            // ここに実行処理を書く
            template.update(updateSql,param);

        }
        return member;
    }
}
