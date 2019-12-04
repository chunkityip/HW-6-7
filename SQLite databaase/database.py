import csv, sqlite3


# By using sqlite libaray to create a database call my_datast and set up the table call t
# For easy mangement , I change the each row name into differents name. Here is the lists :
# aa AS Presentation was well organized.
# bb AS Speaker spoke clearly and was easy to understand.
# cc AS Presenter was enthusiastic about the topic.
# dd AS I learned something new today.
con= sqlite3.connect('my_dataset.db')
cur = con.cursor()
cur.execute("CREATE TABLE t(aa,bb,cc,dd);")

# To be able to read csv file, here is the following code
# Cause there have some non ASCII in this csv file, need to change the encoding to utf-8 and access the errors.
with open('6149.csv','r', encoding ='utf-8', errors ='ignore') as fin:
    dr = csv.DictReader(fin)
    to_db = [(i['aa'], i['bb'],i['cc'],i['dd']) for i in dr]
    sql="SELECT * FROM t;" 
    row=cur.execute(sql).fetchone() 
    average, maximum, minimum = (sum(row) / len(row), max(row), min(row))



cur.executemany("INSERT INTO t(aa,bb,cc,dd) VALUES (?,?,?,?);", to_db)
con.commit()
con.close()
