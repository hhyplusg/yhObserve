create directory expdp_dir as   'd:\';
grant read,write on directory expdp_dir to wave;

expdp wave/wave DIRECTORY=expdp_dir DUMPFILE=wave20180602.dmp SCHEMAS=wave logfile=waveRexpdp.log

create directory impdp_dir as 'd:\';
grant read,write on directory impdp_dir to wave;

impdp wave/wave DIRECTORY=impdp_dir DUMPFILE=wave20180602.dmp logfile=wave.dmpimpdp.log
