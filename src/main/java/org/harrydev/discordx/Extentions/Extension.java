package org.harrydev.discordx.Extentions;

import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus;

public abstract class Extension {

    private ExtensionMetadata metadata = null;

    public final void enable() {
        Validate.notNull(metadata, "Metadata cannot be null!");
        this.onEnable();
    }

    public final void disable() {
        this.onDisable();
    }

    protected abstract void onEnable();

    protected abstract void onDisable();

    public final void setMetadata(ExtensionMetadata metadata) {
        this.metadata = metadata;
    }

    public final String getName() {
        Validate.notNull(metadata, "Metadata cannot be null!");
        return this.metadata.name;
    }

    public final String getVersion() {
        Validate.notNull(metadata, "Metadata cannot be null!");
        return this.metadata.version;
    }

    @ApiStatus.Internal
    public static final class ExtensionMetadata {
        private final @NotNull String version;
        private final @NotNull String name;

        public ExtensionMetadata(@NotNull String version, @NotNull String name) {
            this.version = version;
            this.name = name;
        }
    }
}
