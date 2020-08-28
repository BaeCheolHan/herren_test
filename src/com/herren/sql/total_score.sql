select name, sum(score) as total_score, @rownum := @rownum + 1 as rank

  from midterm, (SELECT @rownum :=0) AS R

  group by name

  order by total_score desc;
