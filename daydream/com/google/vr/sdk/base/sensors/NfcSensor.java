// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NfcSensor.java

package com.google.vr.sdk.base.sensors;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.*;
import android.net.Uri;
import android.nfc.*;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Handler;
import android.util.Log;
import com.google.vr.sdk.base.GvrViewerParams;
import com.google.vr.sdk.base.PermissionUtils;
import java.io.IOException;
import java.util.*;

public class NfcSensor
{
    private static class ListenerHelper
        implements OnCardboardNfcListener
    {

        public OnCardboardNfcListener getListener()
        {
            return listener;
        }

        public void onInsertedIntoGvrViewer(final GvrViewerParams viewerParams)
        {
            handler.post(new Runnable() {

                public void run()
                {
                    listener.onInsertedIntoGvrViewer(viewerParams);
                }

                final GvrViewerParams val$viewerParams;
                final ListenerHelper this$0;

                
                {
                    this.this$0 = ListenerHelper.this;
                    viewerParams = gvrviewerparams;
                    super();
                }
            });
        }

        public void onRemovedFromGvrViewer()
        {
            handler.post(new Runnable() {

                public void run()
                {
                    listener.onRemovedFromGvrViewer();
                }

                final ListenerHelper this$0;

                
                {
                    this.this$0 = ListenerHelper.this;
                    super();
                }
            });
        }

        private OnCardboardNfcListener listener;
        private Handler handler;


        public ListenerHelper(OnCardboardNfcListener listener, Handler handler)
        {
            this.listener = listener;
            this.handler = handler;
        }
    }

    public static interface OnCardboardNfcListener
    {

        public abstract void onInsertedIntoGvrViewer(GvrViewerParams gvrviewerparams);

        public abstract void onRemovedFromGvrViewer();
    }


    public static NfcSensor getInstance(Context context)
    {
        if(sInstance == null)
            sInstance = new NfcSensor(context);
        return sInstance;
    }

    private NfcSensor(Context context)
    {
        this.context = context.getApplicationContext();
        if(PermissionUtils.hasPermission(context, "android.permission.NFC"))
            nfcAdapter = NfcAdapter.getDefaultAdapter(context);
        else
            nfcAdapter = null;
        if(nfcAdapter == null)
        {
            Log.w("NfcSensor", "NFC is not supported on this phone or application doesn't have NFC permission.");
            return;
        } else
        {
            nfcBroadcastReceiver = new BroadcastReceiver() {

                public void onReceive(Context context, Intent intent)
                {
                    onNfcIntent(intent);
                }

                final NfcSensor this$0;

            
            {
                this.this$0 = NfcSensor.this;
                super();
            }
            };
            return;
        }
    }

    public void addOnCardboardNfcListener(OnCardboardNfcListener listener)
    {
        if(listener == null)
            return;
        List list = listeners;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if(listeners.isEmpty())
        {
            IntentFilter ndefIntentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            ndefIntentFilter.addAction("android.nfc.action.TECH_DISCOVERED");
            ndefIntentFilter.addAction("android.nfc.action.TAG_DISCOVERED");
            nfcIntentFilters = (new IntentFilter[] {
                ndefIntentFilter
            });
            context.registerReceiver(nfcBroadcastReceiver, ndefIntentFilter);
        }
        iterator = listeners.iterator();
        ListenerHelper helper;
        do
        {
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_116;
            helper = (ListenerHelper)iterator.next();
        } while(helper.getListener() != listener);
        return;
        listeners.add(new ListenerHelper(listener, new Handler()));
        break MISSING_BLOCK_LABEL_153;
        Exception exception;
        exception;
        throw exception;
    }

    public void removeOnCardboardNfcListener(OnCardboardNfcListener listener)
    {
        if(listener == null)
            return;
        synchronized(listeners)
        {
            Iterator iterator = listeners.iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                ListenerHelper helper = (ListenerHelper)iterator.next();
                if(helper.getListener() != listener)
                    continue;
                listeners.remove(helper);
                break;
            } while(true);
            if(nfcBroadcastReceiver != null && listeners.isEmpty())
                context.unregisterReceiver(nfcBroadcastReceiver);
        }
    }

    public boolean isNfcSupported()
    {
        return nfcAdapter != null;
    }

    public boolean isNfcEnabled()
    {
        return isNfcSupported() && nfcAdapter.isEnabled();
    }

    public boolean isDeviceInCardboard()
    {
        Object obj = tagLock;
        JVM INSTR monitorenter ;
        return currentTagIsCardboard;
        Exception exception;
        exception;
        throw exception;
    }

    public NdefMessage getTagContents()
    {
        Object obj = tagLock;
        JVM INSTR monitorenter ;
        return currentNdef == null ? null : currentNdef.getCachedNdefMessage();
        Exception exception;
        exception;
        throw exception;
    }

    public NdefMessage getCurrentTagContents()
        throws TagLostException, IOException, FormatException
    {
        Object obj = tagLock;
        JVM INSTR monitorenter ;
        return currentNdef == null ? null : currentNdef.getNdefMessage();
        Exception exception;
        exception;
        throw exception;
    }

    public int getTagCapacity()
    {
        Object obj = tagLock;
        JVM INSTR monitorenter ;
        if(currentNdef == null)
            throw new IllegalStateException("No NFC tag");
        return currentNdef.getMaxSize();
        Exception exception;
        exception;
        throw exception;
    }

    public void writeUri(Uri uri)
        throws TagLostException, IOException, IllegalArgumentException
    {
        Object obj = tagLock;
        JVM INSTR monitorenter ;
        NdefMessage newMessage;
        FormatException e;
        if(currentTag == null)
            throw new IllegalStateException("No NFC tag found");
        NdefMessage currentMessage = null;
        newMessage = null;
        NdefRecord newRecord = NdefRecord.createUri(uri);
        try
        {
            currentMessage = getCurrentTagContents();
        }
        // Misplaced declaration of an exception variable
        catch(FormatException e)
        {
            currentMessage = getTagContents();
        }
        if(currentMessage != null)
        {
            ArrayList newRecords = new ArrayList();
            boolean recordFound = false;
            NdefRecord andefrecord[] = currentMessage.getRecords();
            int k = andefrecord.length;
            for(int l = 0; l < k; l++)
            {
                NdefRecord record = andefrecord[l];
                if(isCardboardNdefRecord(record))
                {
                    if(!recordFound)
                    {
                        newRecords.add(newRecord);
                        recordFound = true;
                    }
                } else
                {
                    newRecords.add(record);
                }
            }

            newMessage = new NdefMessage((NdefRecord[])newRecords.toArray(new NdefRecord[newRecords.size()]));
        }
        if(newMessage == null)
            newMessage = new NdefMessage(new NdefRecord[] {
                newRecord
            });
        if(currentNdef == null) goto _L2; else goto _L1
_L1:
        if(!currentNdef.isConnected())
            currentNdef.connect();
        if(currentNdef.getMaxSize() < newMessage.getByteArrayLength())
        {
            int i = currentNdef.getMaxSize();
            int j = newMessage.getByteArrayLength();
            throw new IllegalArgumentException((new StringBuilder(82)).append("Not enough capacity in NFC tag. Capacity: ").append(i).append(" bytes, ").append(j).append(" required.").toString());
        }
        currentNdef.writeNdefMessage(newMessage);
          goto _L3
        i;
        JVM INSTR new #304 <Class RuntimeException>;
        JVM INSTR dup ;
        "Internal error when writing to NFC tag: ";
        String s = String.valueOf(i.toString());
        s;
        if(s.length() == 0) goto _L5; else goto _L4
_L4:
        concat();
          goto _L6
_L5:
        JVM INSTR pop ;
        JVM INSTR new #309 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L6:
        RuntimeException();
        throw ;
_L2:
        NdefFormatable ndef;
        ndef = NdefFormatable.get(currentTag);
        if(ndef == null)
            throw new IOException("Could not find a writable technology for the NFC tag");
        Log.w("NfcSensor", "Ndef technology not available. Falling back to NdefFormattable.");
        ndef.connect();
        ndef.format(newMessage);
        ndef.close();
          goto _L3
        FormatException e;
        e;
        JVM INSTR new #304 <Class RuntimeException>;
        JVM INSTR dup ;
        "Internal error when writing to NFC tag: ";
        String s1 = String.valueOf(e.toString());
        s1;
        if(s1.length() == 0) goto _L8; else goto _L7
_L7:
        concat();
          goto _L9
_L8:
        JVM INSTR pop ;
        JVM INSTR new #309 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L9:
        RuntimeException();
        throw ;
_L3:
        onNewNfcTag(currentTag);
        break MISSING_BLOCK_LABEL_460;
        Exception exception;
        exception;
        throw exception;
    }

    public void onResume(Activity activity)
    {
        if(!isNfcEnabled())
        {
            return;
        } else
        {
            Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
            intent.setPackage(activity.getPackageName());
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            nfcAdapter.enableForegroundDispatch(activity, pendingIntent, nfcIntentFilters, null);
            return;
        }
    }

    public void onPause(Activity activity)
    {
        if(!isNfcEnabled())
        {
            return;
        } else
        {
            nfcAdapter.disableForegroundDispatch(activity);
            return;
        }
    }

    public void onNfcIntent(Intent intent)
    {
        if(!isNfcEnabled() || intent == null || !nfcIntentFilters[0].matchAction(intent.getAction()))
        {
            return;
        } else
        {
            onNewNfcTag((Tag)intent.getParcelableExtra("android.nfc.extra.TAG"));
            return;
        }
    }

    private void onNewNfcTag(Tag nfcTag)
    {
        Tag previousTag;
        Ndef previousNdef;
        boolean previousTagWasCardboard;
label0:
        {
            if(nfcTag == null)
                return;
            synchronized(tagLock)
            {
                previousTag = currentTag;
                previousNdef = currentNdef;
                previousTagWasCardboard = currentTagIsCardboard;
                closeCurrentNfcTag();
                currentTag = nfcTag;
                currentNdef = Ndef.get(nfcTag);
                if(currentNdef != null)
                    break label0;
                if(previousTagWasCardboard)
                    sendDisconnectionEvent();
            }
            return;
        }
        boolean isSameTag;
        isSameTag = false;
        if(previousNdef != null)
        {
            byte tagId1[] = currentTag.getId();
            byte tagId2[] = previousTag.getId();
            isSameTag = tagId1 != null && tagId2 != null && Arrays.equals(tagId1, tagId2);
            if(!isSameTag && previousTagWasCardboard)
                sendDisconnectionEvent();
        }
        NdefMessage nfcTagContents;
        currentNdef.connect();
        nfcTagContents = currentNdef.getCachedNdefMessage();
        break MISSING_BLOCK_LABEL_206;
        Exception e;
        e;
        "NfcSensor";
        "Error reading NFC tag: ";
        String s = String.valueOf(e.toString());
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #309 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.e();
        JVM INSTR pop ;
        if(isSameTag && previousTagWasCardboard)
            sendDisconnectionEvent();
        obj;
        JVM INSTR monitorexit ;
        return;
        currentTagIsCardboard = isCardboardNdefMessage(nfcTagContents);
        if(!isSameTag && currentTagIsCardboard)
            synchronized(listeners)
            {
                ListenerHelper listener;
                for(Iterator iterator = listeners.iterator(); iterator.hasNext(); listener.onInsertedIntoGvrViewer(GvrViewerParams.createFromNfcContents(nfcTagContents)))
                    listener = (ListenerHelper)iterator.next();

            }
        if(currentTagIsCardboard)
        {
            tagConnectionFailures = 0;
            nfcDisconnectTimer = new Timer("NFC disconnect timer");
            nfcDisconnectTimer.schedule(new TimerTask() {

                public void run()
                {
                    synchronized(tagLock)
                    {
                        if(!currentNdef.isConnected())
                        {
                            ++tagConnectionFailures;
                            if(tagConnectionFailures > 1)
                            {
                                closeCurrentNfcTag();
                                sendDisconnectionEvent();
                            }
                        }
                    }
                }

                final NfcSensor this$0;

            
            {
                this.this$0 = NfcSensor.this;
                super();
            }
            }, 250L, 250L);
        }
        obj;
        JVM INSTR monitorexit ;
          goto _L4
        exception1;
        throw exception1;
_L4:
    }

    private void closeCurrentNfcTag()
    {
        if(nfcDisconnectTimer != null)
            nfcDisconnectTimer.cancel();
        if(currentNdef == null)
            return;
        try
        {
            currentNdef.close();
        }
        catch(IOException e)
        {
            Log.w("NfcSensor", e.toString());
        }
        currentTag = null;
        currentNdef = null;
        currentTagIsCardboard = false;
    }

    private void sendDisconnectionEvent()
    {
        synchronized(listeners)
        {
            ListenerHelper listener;
            for(Iterator iterator = listeners.iterator(); iterator.hasNext(); listener.onRemovedFromGvrViewer())
                listener = (ListenerHelper)iterator.next();

        }
    }

    private boolean isCardboardNdefMessage(NdefMessage message)
    {
        if(message == null)
            return false;
        NdefRecord andefrecord[] = message.getRecords();
        int i = andefrecord.length;
        for(int j = 0; j < i; j++)
        {
            NdefRecord record = andefrecord[j];
            if(isCardboardNdefRecord(record))
                return true;
        }

        return false;
    }

    private boolean isCardboardNdefRecord(NdefRecord record)
    {
        if(record == null)
        {
            return false;
        } else
        {
            Uri uri = record.toUri();
            return uri != null && GvrViewerParams.isGvrUri(uri);
        }
    }

    private static final String TAG = "NfcSensor";
    private static final int MAX_CONNECTION_FAILURES = 1;
    private static final long NFC_POLLING_INTERVAL_MS = 250L;
    private static NfcSensor sInstance;
    private final Context context;
    private final NfcAdapter nfcAdapter;
    private final Object tagLock = new Object();
    private final List listeners = new ArrayList();
    private BroadcastReceiver nfcBroadcastReceiver;
    private IntentFilter nfcIntentFilters[];
    private Ndef currentNdef;
    private Tag currentTag;
    private boolean currentTagIsCardboard;
    private Timer nfcDisconnectTimer;
    private int tagConnectionFailures;






}
