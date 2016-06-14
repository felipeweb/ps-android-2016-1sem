package br.com.fiap.provasemesrtalapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class ValidaLoginService extends Service {

	private NotificationManager nm;
	private Notification.Builder nb;

	public ValidaLoginService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public int onStartCommand(Intent intent, int flag, int id) {

		String email = intent.getExtras().getString("email");
		String senha = intent.getExtras().getString("senha");

		String mensagem = "";

		if ((email != null && email.equalsIgnoreCase("felipeweb"))
				&& (senha != null && senha.equalsIgnoreCase("2602"))) {

			mensagem = "Login válido";
		} else {
			mensagem = "Login inválido";
		}

		nm = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
		nb = new Notification.Builder(this);
		nb.setContentTitle("Aviso");
		nb.setContentText(mensagem);
		nb.setSmallIcon(R.mipmap.ic_launcher);

		nb.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));

		Notification n = nb.build();

		nm.notify(100, n);

		return 1;
	}
}
