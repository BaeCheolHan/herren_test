update midterm set

        score =(select score

                  from ( select  AVG(score) + 15 as score

                              from midterm

                           where subject = '수학' and (name = '여우' or name='돼지')

                          )t1),

        updated_at = now()



 where subject = '수학' and name='늑대';
