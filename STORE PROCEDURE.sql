
use avance1bd;

DELIMITER batman
	-- Iniciar el STORED PROCEDURE
CREATE PROCEDURE RealizarTransferencia_SP(
    IN cuentaOrigen_SP int,
    IN cuentaDestino_SP int,
    IN monto_SP int
)
BEGIN
    DECLARE cuentaOrigen_id_SP int;
    DECLARE cuentaDestino_id_SP int;

    -- Obtiene los ids de las cuentas de origen y destino
    SELECT cuenta_id INTO cuentaOrigen_id_SP FROM Cuentas WHERE numeroCuenta = cuentaOrigen_SP;
    SELECT cuenta_id INTO cuentaDestino_id_SP FROM Cuentas WHERE numeroCuenta = cuentaDestino_SP;

    -- Verificar que las cuentas existan
    IF cuentaOrigen_id_SP IS NOT NULL AND cuentaDestino_id_SP IS NOT NULL THEN
       
       
       -- Iniciar la TRANSACCION
        START TRANSACTION;

		-- Actualizaa Saldos de la cuenta origen y destino
        UPDATE Cuentas SET saldo = saldo - monto_SP WHERE cuenta_id = cuentaOrigen_id_SP;

        UPDATE Cuentas SET saldo = saldo + monto_SP WHERE cuenta_id = cuentaDestino_id_SP;

        -- Registro de la transferencia
        INSERT INTO Transferencias (cuentaDestino, monto, fecha, cuenta_id) VALUES (cuentaDestino_id_SP, monto_SP, NOW(), cuentaOrigen_id_SP);

        -- Confirmar la transacción si todo está bien
        COMMIT;
    
        -- Revertir la transacción si alguna cuenta no existe
        ROLLBACK;
    END IF;
END batman

DELIMITER ;