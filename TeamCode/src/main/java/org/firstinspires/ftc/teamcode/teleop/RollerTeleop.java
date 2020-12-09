package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "RollerTeleop", group = "Teleop")
public class RollerTeleop extends EverythingConfig {



    private float rollers;




    public void runOpMode() {


        try {
            initializeHardware();

            waitForStart();

            while (opModeIsActive()) {
                setServo(0.5);
                Thread.sleep(5000);
                setServo(0.55);
                Thread.sleep(5000);
            }

            telemetry.addData("Status", "Done");
            telemetry.update();
        } catch (Exception e) {
            telemetry.addData("Status", e.toString());
        }
    }

}
