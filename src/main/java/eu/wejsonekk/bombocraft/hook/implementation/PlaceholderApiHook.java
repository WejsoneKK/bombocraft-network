package eu.wejsonekk.bombocraft.hook.implementation;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import eu.wejsonekk.starblock.hook.Hook;
import eu.wejsonekk.starblock.itemshop.wallet.Wallet;
import eu.wejsonekk.starblock.itemshop.wallet.WalletRepository;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PlaceholderApiHook extends PlaceholderExpansion implements Hook {

    private final AsyncLoadingCache<UUID, Wallet> walletCache;

    public PlaceholderApiHook(WalletRepository walletRepository) {
        this.walletCache = Caffeine.newBuilder()
                .refreshAfterWrite(3, TimeUnit.SECONDS)
                .buildAsync(key -> walletRepository.findWallet(key).get(15, TimeUnit.SECONDS));
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (params.equalsIgnoreCase("money")) {
            UUID uuid = player.getUniqueId();
            Wallet wallet = this.walletCache.synchronous().getIfPresent(uuid);

            if (wallet == null) {
                return "0";
            }

            return String.valueOf(wallet.getMoney());
        }

        return "Unknown placeholder";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "sbitemshop";
    }

    @Override
    public @NotNull String getAuthor() {
        return "WejsoneKKEU";
    }

    @Override
    public @NotNull String getVersion() {
        return "0.1.0";
    }

    @Override
    public void initialize() {
        this.register();
    }

    @Override
    public String pluginName() {
        return "PlaceholderAPI";
    }

    public AsyncLoadingCache<UUID, Wallet> getWalletCache() {
        return this.walletCache;
    }

}