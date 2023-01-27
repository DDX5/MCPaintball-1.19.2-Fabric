package org.multicoder.mcpaintball.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.multicoder.mcpaintball.MCPaintball;

public class soundinit
{
    public static final SoundEvent SPLAT = RegsiterSound("splat");
    public static final SoundEvent DING = RegsiterSound("ding");
    public static final SoundEvent SINGLE = RegsiterSound("single");
    public static final SoundEvent SET = RegsiterSound("set");
    public static final SoundEvent REM = RegsiterSound("rem");
    public static final SoundEvent DET = RegsiterSound("det");

    private static SoundEvent RegsiterSound(String name)
    {
        return Registry.register(Registry.SOUND_EVENT,new Identifier(MCPaintball.ModID,name),
                new SoundEvent(new Identifier(MCPaintball.ModID,name)));
    }

    public static void RegisterSounds()
    {

    }
}
