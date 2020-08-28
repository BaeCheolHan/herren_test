select name, sum(score) as total_score

  from midterm

  group by name having total_score > 200;
