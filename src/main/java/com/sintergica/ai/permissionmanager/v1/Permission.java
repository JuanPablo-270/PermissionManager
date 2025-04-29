package com.sintergica.ai.permissionmanager.v1;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Permission {
    READ(1, "Read", "Permission to read data"),
    WRITE(2, "Write", "Permission to write data"),
    EXECUTE(3, "Execute", "Permission to execute commands"),
    DELETE(4, "Delete", "Permission to delete data"),
    UPDATE(5, "Update", "Permission to update data"),
    CREATE(6, "Create", "Permission to create new data"),
    VIEW(7, "View", "Permission to view data"),
    MANAGE(8, "Manage", "Permission to manage data"),
    ADMIN(9, "Admin", "Permission to administer the system"),
    CONFIGURE(10, "Configure", "Permission to configure settings"),
    MONITOR(11, "Monitor", "Permission to monitor system activity"),
    BACKUP(12, "Backup", "Permission to backup data"),
    RESTORE(13, "Restore", "Permission to restore data"),
    SHARE(14, "Share", "Permission to share data"),
    UPLOAD(15, "Upload", "Permission to upload files"),
    DOWNLOAD(16, "Download", "Permission to download files"),
    SYNC(17, "Sync", "Permission to synchronize data"),
    ARCHIVE(18, "Archive", "Permission to archive data"),
    UNARCHIVE(19, "Unarchive", "Permission to unarchive data"),
    EXPORT(20, "Export", "Permission to export data"),
    IMPORT(21, "Import", "Permission to import data"),
    PRINT(22, "Print", "Permission to print data"),
    SHARE_LINK(23, "Share Link", "Permission to share data via link"),
    COLLABORATE(24, "Collaborate", "Permission to collaborate with others"),
    APPROVE(25, "Approve", "Permission to approve requests"),
    REJECT(26, "Reject", "Permission to reject requests"),
    NOTIFY(27, "Notify", "Permission to send notifications"),
    SUBSCRIBE(28, "Subscribe", "Permission to subscribe to updates"),
    UNSUBSCRIBE(29, "Unsubscribe", "Permission to unsubscribe from updates"),
    FOLLOW(30, "Follow", "Permission to follow users or data"),
    UNFOLLOW(31, "Unfollow", "Permission to unfollow users or data"),
    LIKE(32, "Like", "Permission to like content"),
    DISLIKE(33, "Dislike", "Permission to dislike content"),
    COMMENT(34, "Comment", "Permission to comment on content"),
    REPLY(35, "Reply", "Permission to reply to comments"),
    MENTION(36, "Mention", "Permission to mention users"),
    TAG(37, "Tag", "Permission to tag users or data"),
    BLOCK(38, "Block", "Permission to block users"),
    UNBLOCK(39, "Unblock", "Permission to unblock users"),
    REPORT(40, "Report", "Permission to report content"),
    FLAG(41, "Flag", "Permission to flag content"),
    HIDE(42, "Hide", "Permission to hide content"),
    SHOW(43, "Show", "Permission to show content"),
    PIN(44, "Pin", "Permission to pin content"),
    UNPIN(45, "Unpin", "Permission to unpin content"),
    FOCUS(46, "Focus", "Permission to focus on content"),
    ZOOM(47, "Zoom", "Permission to zoom in/out on content"),
    FILTER(48, "Filter", "Permission to filter content"),
    SORT(49, "Sort", "Permission to sort content"),
    SEARCH(50, "Search", "Permission to search for content");

    public static final EnumSet<Permission> ALL_PERMISSIONS = EnumSet.allOf(Permission.class);

    private final int id;
    private final String name;
    private final String description;

    Permission(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    
    public static Permission fromId(int id) {
        for (Permission permission : Permission.values()) {
            if (permission.getId() == id) {
                return permission;
            }
        }
        throw new IllegalArgumentException("No permission found with id: " + id);
    }
    public static Permission fromName(String name) {
        for (Permission permission : Permission.values()) {
            if (permission.getName().equalsIgnoreCase(name)) {
                return permission;
            }
        }
        throw new IllegalArgumentException("No permission found with name: " + name);
    }
    public static Permission fromDescription(String description) {
        for (Permission permission : Permission.values()) {
            if (permission.getDescription().equalsIgnoreCase(description)) {
                return permission;
            }
        }
        throw new IllegalArgumentException("No permission found with description: " + description);
    }
    public static Permission[] getAllPermissions() {
        return Permission.values();
    }

}