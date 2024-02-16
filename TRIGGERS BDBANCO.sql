-- triggers de banco
use avance1bd;

delimiter //
create trigger numeroCuenta
before insert on cuentas
for each row
begin
    declare numCue bigint;
    set numCue = floor(rand() * 10000000000000000);
    set new.numeroCuenta = lpad(numCue, 16, '0');
    set new.fechaApertura = now();
end//
delimiter ;

 -- drop trigger numeroCuenta;

