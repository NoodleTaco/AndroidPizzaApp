package com.example.cs213project5new;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * This class holds the functionality to create AlertDilog
 * @author Donald Yubeaton, Michael Kassie
 */
public class AlertDialogMaker {
    /**
     * Shows an Alert Dialog with a set title and message given the context of the activity
     * @param context The Current Activity's context
     * @param title Title of the message
     * @param message The message displayed
     */
    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // Setting OK Button
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Do something when OK button is clicked
                dialog.dismiss();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

}
