create tablespace TBS_WAVEPLUS 
datafile 'C:/app/Administrator/oradata/orcl/TBS_WAVEPLUS.dbf' 
size 1024M 
autoextend on next 5M maxsize 3000M;

create tablespace TBS_WAVEPLUS_INDEX 
datafile 'C:/app/Administrator/oradata/orcl/TBS_WAVEPLUS_INDEX.dbf' 
size 1024M 
autoextend on next 5M maxsize 3000M;

create user wave identified by wave 
default tablespace TBS_WAVEPLUS;




grant connect,resource to wave;
grant create any sequence to wave;
grant create any table to wave;
grant delete any table to wave;
grant insert any table to wave;
grant select any table to wave;
grant unlimited tablespace to wave;
grant execute any procedure to wave;
grant update any table to wave;
grant create any view to wave;

--如果上述表空间创建失败，可以通过以下语句删除
drop tablespace TBS_WAVEPLUS including contents and datafiles;
drop tablespace TBS_WAVEPLUS_INDEX including contents and datafiles;
drop user wave cascade;
--End 如果上述表空间创建失败，可以通过以下语句删除



