select name, subject, score
  from (select name, subject, score from midterm order by score asc) as t1

  group by subject order by subject asc;
